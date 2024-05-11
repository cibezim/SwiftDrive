import { getFirestore, doc, setDoc, getDoc, updateDoc, deleteDoc } from 'firebase/firestore';
import firebaseApp from '../firebaseConfig';

const db = getFirestore(firebaseApp);

// Create or update user data in Firestore
export const updateUser = async (userId, userData) => {
  const userRef = doc(db, 'users', userId);
  await setDoc(userRef, userData, { merge: true });
};

// Get user data from Firestore
export const getUserById = async (userId) => {
  const userRef = doc(db, 'users', userId);
  const userDoc = await getDoc(userRef);
  return userDoc.exists() ? userDoc.data() : null;
};

// Update user profile data
export const updateUserProfile = async (userId, profileData) => {
  const userRef = doc(db, 'users', userId);
  await updateDoc(userRef, profileData);
};

// Delete user data from Firestore
export const deleteUser = async (userId) => {
  const userRef = doc(db, 'users', userId);
  await deleteDoc(userRef);
};
