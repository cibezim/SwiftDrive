import { getFirestore, collection, addDoc, getDocs, updateDoc, deleteDoc } from 'firebase/firestore';
import firebaseApp from '../firebaseConfig';

const db = getFirestore(firebaseApp);

// Create a new document in a Firestore collection
export const addDocument = async (collectionName, data) => {
  const newDocRef = await addDoc(collection(db, collectionName), data);
  return newDocRef.id;
};

// Get all documents from a Firestore collection
export const getAllDocuments = async (collectionName) => {
  const querySnapshot = await getDocs(collection(db, collectionName));
  return querySnapshot.docs.map((doc) => ({ id: doc.id, ...doc.data() }));
};

// Update a document in a Firestore collection
export const updateDocument = async (collectionName, docId, data) => {
  const docRef = doc(db, collectionName, docId);
  await updateDoc(docRef, data);
};

// Delete a document from a Firestore collection
export const deleteDocument = async (collectionName, docId) => {
  const docRef = doc(db, collectionName, docId);
  await deleteDoc(docRef);
};
