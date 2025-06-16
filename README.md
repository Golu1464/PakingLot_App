# 🚗 ParkingLotAppFX

A JavaFX-based Parking Lot Management desktop application.

## 📁 Project Structure

```
ParkingLotAppFX/
├── build.gradle
├── src/
│   └── main/
│       └── java/
│           ├── ParkingLotAppFX.java          # Main Application Entry
│           ├── ParkingLotManager.java        # Business Logic
│           └── Vehicle.java                  # Data Model
├── styles/
│   └── app.css                               # App Styling
├── build/
│   └── libs/
│       └── ParkingLotAppFX.jar               # JAR output after build
```

---

## ⚙️ Prerequisites

- **Java JDK 17+** installed and added to `PATH`
- **Gradle** (or use `gradlew`)
- **JavaFX SDK 17** downloaded from [https://gluonhq.com/products/javafx/](https://gluonhq.com/products/javafx/)
- Environment variable (for packaging):
  ```
  set PATH_TO_FX="C:\path\to\javafx-sdk-17\lib"
  ```

---

## 🚀 How to Run the App

### ▶️ Run using Gradle

In the root directory:

```bash
./gradlew run
```

Or on Windows:

```cmd
gradlew.bat run
```

> The app will open in a new window.

---

## 📦 How to Package into .EXE (Windows Installer)

### 1. Make sure `jpackage` is available (comes with JDK 14+):

```cmd
jpackage --version
```

If not found, add this to your PATH:

```cmd
set PATH=%PATH%;C:\Program Files\Java\jdk-17\bin
```

---

### 2. Build the JAR

```cmd
gradlew.bat build
```

---

### 3. Package with `jpackage`

```cmd
set PATH_TO_FX="C:\path\to\javafx-sdk-17\lib"

jpackage ^
  --type exe ^
  --input build\libs ^
  --name ParkingLotApp ^
  --main-jar ParkingLotAppFX.jar ^
  --main-class ParkingLotAppFX ^
  --java-options "--module-path %PATH_TO_FX% --add-modules javafx.controls"
```

---

## ✅ Output

An installable `.exe` will be generated in the same directory, which can be used to install the app on any Windows PC.

---

## 📄 License

This project is for educational/demo purposes. Feel free to fork or modify.
