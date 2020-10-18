## QR Code Generator Tutorial

This tutorial explains the QR Code Generator demo and shows you how to deploy it to the Nimbella Cloud.

This app is a stateless single-page web application that generates a [QR code](https://en.wikipedia.org/wiki/QR_code) from text that a user submits. You can [try out the application here](https://qrdemo-apigcp.nimbella.io).

This project has the following components:

- A single [`index.html`](./web/index.html) file, which has a field for a visitor to enter some text and click **Submit**.
- A single JavaScript file [`qr.js`](./packages/default/qr/qr.js) that provides the backend logic for the conversion of text to QR code.
- A Node package manager file called [`package.json`](./packages/default/qr/package.json), which describes what dependencies the function has.

### Project file structure

The GitHub project has the file structure that Nimbella uses to intelligently deploy the project:

![](../images/qrcodetutorial-d1d54d1b.svg)

The [`packages`](./packages) directory contains the project's API implementation, and in this example, there's only one API implemented by a single function, known as an _action_. The first subdirectory name usually serves as the package qualifier. The next subdirectory, [`qr`](./packages/default/qr), is the name of the action, and the file [`qr.js`](./packages/default/qr/qr.js) contains the logic for that action. The qualified name of the action is also the name of the API it implements which is `default/qr` in this case.

The [`web`](./web) directory contains the web content for the project. In this case, there is just one HTML file and one image. The [`index.html`](./web/index.html) file contains a form with a text box for the user to input the text that will be converted.

### Notes on QR logic

The code for the QR action is standard Node.js. It uses an existing Node [library](https://www.npmjs.com/package/qrcode) package for the actual QR code generation.

### Notes on QR web content

The [`index.html`](./web/index.html) file contains the usual markup and logic that you'd write for standard web deployment, with an input form for text. In this case, it calls an API to retrieve a QR code for the form input. This API is implemented by [`qr.js`](./packages/default/qr/qr.js).

### Notes on `package.json`

The [`package.json`](./packages/default/qr/package.json) file in the [`qr`](./packages/default/qr) directory triggers an automatic build of the action when the function in [`qr.js`](./packages/default/qr/qr.js) is modified. For more information about builds, see the [section on incorporating build steps in the Nimbella Command Line Tool Guide](https://nimbella.io/downloads/nim/nim.html#incorporating-build-steps-for-actions-and-web-content).

### Deploy this project to the Nimbella Cloud

If you have the [Nimbella command line tool called `nim`](https://nimbella.io/downloads/nim/nim.html#install-the-nimbella-command-line-tool-nim) installed, you can deploy this project directly from GitHub. Or, you can clone this repository and deploy from the clone.

- To deploy from GitHub

  `nim project deploy github:nimbella/demo-projects/qrcode`

- If you have cloned the repository

   `nim project deploy /path/to/qrcode`

The output of this command will include a link to where the application is running in the cloud for your account.

### Notes on Alternate Implementation

The QR Code generator is implemented in Node.js and in Java. The Java implementation is located in [`qr-java`](./packages/default/qr-java). Maven is used to build the JAR.
