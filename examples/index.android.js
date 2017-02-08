/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  Platform,
  TouchableHighlight,
  NativeModules,
  View
} from 'react-native';

import { STTandroid, STTios } from 'react-native-speech-to-text';

export default class examples extends Component {

  render() {
    return (
      <View style={styles.container}>
        <TouchableHighlight onPress={() => {
          if(Platform.OS === 'android') {
              STTandroid.showGoogleInputDialog()
                  .then((result) => {
                      console.log(result)
                  })
                  .catch((error) => {
                      console.log(error)
                  })

          } else if(Platform.OS === 'ios') {
              sttIOS.startRecording();
              //sttIOS.callbackMethod((err,r) => console.log(r.success));
          }
        }}>
            <Text>
                Click here to test the speech to text functionality
            </Text>
        </TouchableHighlight>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

AppRegistry.registerComponent('examples', () => examples);
