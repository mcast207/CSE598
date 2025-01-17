import UIKit

class ViewController: UIViewController {
    
    // Outlets for UI elements
    @IBOutlet weak var heightTextField: UITextField!
    @IBOutlet weak var weightTextField: UITextField!
    @IBOutlet weak var bmiLabel: UILabel!
    @IBOutlet weak var bmiValue: UILabel!
    @IBOutlet weak var riskLabel: UILabel!
    @IBOutlet weak var callBMIButton: UIButton!
    @IBOutlet weak var educateMeButton: UIButton!
    
    var moreLinks: [String] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    @IBAction func calculateBMI(_ sender: UIButton) {

        guard let heightText = heightTextField.text, !heightText.isEmpty,
              let weightText = weightTextField.text, !weightText.isEmpty,
              let height = Int(heightText), let weight = Int(weightText) else {
            
            // Display an error message if input is invalid
            riskLabel.text = "Please enter valid height\nand weight!"
            riskLabel.numberOfLines = 0
            riskLabel.textAlignment = .center
            riskLabel.textColor = UIColor.red
            return
        }
        
        // Clear any previous error message
        riskLabel.text = ""
        riskLabel.textColor = UIColor.black
        
        // Proceed with the API call
        fetchBMIData(height: height, weight: weight)
    }

    
    @IBAction func educateMe(_ sender: UIButton) {
    
        if !moreLinks.isEmpty {
            //Randomize which link will be opened upon user clicking "Educate Me" button
            if let randomLink = moreLinks.randomElement(), let url = URL(string: randomLink){
                 UIApplication.shared.open(url)
            }
        }else{
            riskLabel.text = "Click 'Call BMI API' first!"
            riskLabel.textColor = UIColor.orange
        }
    }
    
    func fetchBMIData(height: Int, weight: Int) {
        let urlString = "http://scai-bmi-calculator.us-west-2.elasticbeanstalk.com/api/BMI/calculateBMI?height=\(height)&weight=\(weight)"
        
        guard let url = URL(string: urlString) else {
            print("Invalid URL")
            return
        }

        URLSession.shared.dataTask(with: url) { data, response, error in
            // Handle errors
            if let error = error {
                print("Error fetching data: \(error.localizedDescription)")
                return
            }

            guard let data = data else {
                print("No data received")
                return
            }

            do {
                // Parse JSON response
                let jsonResponse = try JSONSerialization.jsonObject(with: data, options: [])
                
                if let jsonDict = jsonResponse as? [String: Any] {
                    // Update UI on the main thread
                    DispatchQueue.main.async {
                        self.updateUI(with: jsonDict)
                    }
                } else {
                    print("Failed to cast JSON response to dictionary")
                }
            } catch {
                print("Error parsing JSON: \(error.localizedDescription)")
            }
        }.resume()
    }
    
    //Need to parse double val as a string for bmiValue.text
    var bmiValueDouble: Double? {
            didSet {
                if let bmiValueDouble = bmiValueDouble {
                    bmiValue.text = String(format: "%.2f", bmiValueDouble)
                } else {
                    bmiValue.text = nil
                }
            }
        }

    // Update UI for any changes
    func updateUI(with data: [String: Any]) {
        if let bmi = data["bmi"] as? Double {
            bmiValueDouble = bmi
        }
        
        if let risk = data["risk"] as? String {
            riskLabel.text = risk
            switch risk {
            case "You are underweight :(":
                riskLabel.textColor = UIColor.blue
            case "You are normal :)":
                riskLabel.textColor = UIColor.green
            case "You are pre-obese!":
                riskLabel.textColor = UIColor.purple
            default:
                riskLabel.textColor = UIColor.red
            }
        }
        
        if let links = data["more"] as? [String]{
            moreLinks = links
        }
    }
}
