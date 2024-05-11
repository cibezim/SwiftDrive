import { getMessaging, getToken, onMessage } from 'firebase/messaging';
import firebaseApp from '../firebaseConfig';

const messaging = getMessaging(firebaseApp);

// Get the device token for the current user
export const getDeviceToken = async () => {
  try {
    const token = await getToken(messaging, { vapidKey: 'YOUR_VAPID_KEY' });
    console.log('Device token:', token);
    return token;
  } catch (error) {
    console.error('Error getting device token:', error);
    return null;
  }
};

// Listen for incoming messages (foreground and background)
export const listenForMessages = () => {
  onMessage(messaging, (payload) => {
    console.log('Message received:', payload);
    // Handle the incoming message (e.g., show a notification)
  });
};
