# React Native Speech to Text

React Native module that allows an React Native application to call native speech recognition APIs and to get the recognized text in return.

## Installation

### First step(Download):
Run `npm i react-native-speech-to-text --save`

### Second step(Plugin Installation):

#### Automatic installation

`react-native link react-native-speech-to-text`

## Getting started  

`import { STTandroid, STTios } from 'react-native-speech-to-text';`

```
(Platform.OS === 'android') {
   STTandroid.showGoogleInputDialog()
       .then((result) => {
           console.log(result)
       })
       .catch((error) => {
           console.log(error)
       })

} 
