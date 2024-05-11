// firebaseConfig.js

import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";

// Your Firebase configuration
const firebaseConfig = {
    apiKey: "AIzaSyCnpMxmLonzW6V2Oc3oPb3UoW4G-IM9aBc",
    authDomain: "swiftdrive-c669a.firebaseapp.com",
    projectId: "swiftdrive-c669a",
    storageBucket: "swiftdrive-c669a.appspot.com",
    messagingSenderId: "34183095608",
    appId: "1:34183095608:web:ac8bac37f9aaa4f2444dcd",
    measurementId: "G-3RRGWH5MWG"
};

// Initialize Firebase
const firebaseApp = initializeApp(firebaseConfig);
const analytics = getAnalytics(firebaseApp);

export default firebaseApp;
