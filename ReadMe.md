# 🌦 Weather App (Java)

A command-line weather application built using Java that fetches real-time weather data from the OpenWeather API.

---

## 🚀 Features

* 🌍 Get real-time weather data for any city
* 🌡 Displays temperature, feels like, humidity, and wind speed
* 🔁 Loop-based interaction (check multiple cities)
* ❌ Handles invalid city and API errors gracefully
* 🔐 Secure API key handling using environment variables

---

## 🛠 Tech Stack

* Java (JDK 11+)
* HTTP Client API
* Gson (for JSON parsing)
* OpenWeather API

---

## 📁 Project Structure

```
weather-app-java/
│
├── WeatherApp.java
├── lib/
│   └── gson-2.10.1.jar
├── .gitignore
└── README.md
```

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/weather-app-java.git
cd weather-app-java
```

---

### 2️⃣ Set your API key (IMPORTANT)

Get your API key from OpenWeather and set it as an environment variable:

#### Mac/Linux:

```bash
export WEATHER_API_KEY=your_api_key_here
```

#### Windows (CMD):

```bash
set WEATHER_API_KEY=your_api_key_here
```

---

### 3️⃣ Compile the project

```bash
javac -cp .:lib/gson-2.10.1.jar WeatherApp.java
```

---

### 4️⃣ Run the application

#### Mac/Linux:

```bash
java -cp .:lib/gson-2.10.1.jar WeatherApp
```

#### Windows:

```bash
java -cp .;lib/gson-2.10.1.jar WeatherApp
```

---

## 🧪 Example Usage

```
====================================
🌤 Welcome to the Weather App 🌤
====================================

Enter city: Chennai

🌤 Weather Report
----------------------------
City        : Chennai
Temperature : 32°C
Feels Like  : 34°C
Humidity    : 70%
Wind Speed  : 3 m/s
Condition   : scattered clouds
----------------------------

Do you want to check another city? (yes/no): no

👋 Thank you for using the Weather App!
```

---

## 🔐 Security Note

* ❌ Do NOT hardcode your API key in the source code
* ✅ Always use environment variables (`WEATHER_API_KEY`)
* 🔄 Regenerate your key if accidentally exposed

---

## 🧠 Learnings from this Project

* Working with REST APIs in Java
* Handling HTTP requests and responses
* Parsing JSON using Gson
* Managing external libraries manually
* Writing clean, user-friendly CLI applications

---

## 🚀 Future Improvements

* GUI version using JavaFX
* Save search history
* Add weather icons
* Convert to backend API using Spring Boot
* Deploy as a web service

---

## 👨‍💻 Author

**Jay Jariwala**
📧 [jjariwala111@gmail.com](mailto:jjariwala111@gmail.com)
🌐 Portfolio: https://sites.google.com/view/jays-porfolio/home

---

## ⭐ Support

If you found this project useful, consider giving it a ⭐ on GitHub!

---
