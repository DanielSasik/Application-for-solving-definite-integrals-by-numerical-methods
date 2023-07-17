# Application-for-solving-definite-integrals-by-numerical-methods
App designed to calculate definite integrals using numerical methods such as rectangle rule, trapezoid rule, Simpson's 1/3 rule, Simpson's 3/8 rule and Boole's rule. 

Video showcase: https://youtu.be/DSgEPfT9O-I

## Short summary
This application functions as a numerical calculator for definitive integrals. It has graphical user interface, made to be user-friendly, guide for the application is provided in the app. The app is in Slovak language. This app provides user with panel onto which set mathematical function is plotted. User can interact with set plotted graph. App detects if set mathematical functions is continuos or not. Also there are exceptions for error inputs such as wrong inputs, wrongly typed mathematical function, beggining of the interval being bigger than the end of the interval etc...

The code isn't the most readible, it's something I am working on to get better, but the working result is all that mattered in school.

## Functional requirements

| N        | Functional requirements           | Additional information  |
| ------------- |:-------------:| :-----:|
| R01     | Calculating definite integral | Based on the inputs, like beggining and end of interval, input mathematical function, number of dividing intervals, this app will use chosen numerical methods to calculate the result.       |
| R02     | Checking inputs               | The app will check whether all inputs are correct. In case of error the app will show an error message.  |
| R03     | Cheking continuity            | The app will check if mathematical function is continuous on set interval. In case it's discontinuous it will show a message to inform the user.  |
| R04   | Plotting set mathematical function   | App will plot mathematical function on x y axis, depdending if it's continuous it will show the area under the curve, in case its not continuous it will only show curves. |
| R05     | Shows user guide and used equations   |    App will show window for user guide or window for used mathematical equations, approximation rule's for defnite integrals. |

## Nonfunctional requirements

| N        | Nonfunctional requirements           | Additional information  |
| ------------- |:-------------:| :-----:|
| R06     | App is programmed in Java   |    - |
| R07     | IDE used for development of this app is Eclipse, for GUI toolkit Swing is used   |    - |
| R08     | App is compatible with variable operating systems  |    Java is compatible with variable operating systems. If JRE - Java Runtime Enviroment is installed, the app is compatible. |
| R09     | App is available in Slovak language   |    - |

## Finding users

| N        | User       | Additional information  |
| ------------- |:-------------:| :-----:|
| A01     | User of the application   | It's a simple app with just one user, that will use it for calculating and visualising definite integrals. |

## Finding use case scenarios

| N        | Use case       | Additional information  | Req.  |
| ------------- |:-------------:| :-----:| :-----:|
| UC01     | Calculating definite integral | User can calculate result for chosen numerical methods and input mathematical function, after pressing button "Vypočítaj" (Calculate) | R01, R02, R03, R04 |
| UC02     | Choosing numerical methods | User can choose which methods to use with the help of checkbox GUI component  | R01 |
| UC03     | Inputing mathematical function  | User can input mathematical function with one variable 'x'. User can use the keyboard or buttons. |R01 |
| UC04     | Input values | User can specify neccesary values like beggining and end of the interval or number of dividing subintervals.  | R01 |
| UC05     | Clear input mathematical function | User can use the keyboard or buttons "⌫" (backspace) or "C" (clear).  | R01 |
| UC06     | Checking input values | After pressing button "Vypočítaj" (Calculate) the app will check if input values don't result in error.  | R01 |
| UC07     | Checking if function is continuous | After pressing button "Vypočítaj" (Calculate) the app will check if input mathematical function is continuous.  | R01 |
| UC08     | Plotting mathematical function | After pressing button "Vypočítaj" (Calculate) and all checks, the app will plot a mathematical function.  | R02, R03, R04 |
| UC09     | Zoom in, Zoom out and Reset with buttons | With buttons there will be ability for the user to zoom in, zoom out or reset to original view of plotted graph.  | R04 |
| UC10     | Zoom in and Reset with mouse | With the usage of mouse on drag the user will be able to zoom into certain area of the plotted graph or reset to original view of plotted graph.  | R04 |
| UC11     | Showing menu | User will have the ability to use the menu called "Pomôcka" (help), and choose menu items "Používateľská príručka" (user guide) or "Vzťahy" (Equations).   | R05 |
