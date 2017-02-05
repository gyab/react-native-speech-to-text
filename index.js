import { NativeModules } from 'react-native';

let sttAndroid =  NativeModules.SpeechToText;
let sttIOS =  NativeModules.SpeechTT;

export { sttAndroid, sttIOS };