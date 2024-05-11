import { getFirestore, collection, addDoc, getDocs, doc, updateDoc, deleteDoc } from 'firebase/firestore';
import { firebaseApp } from './firebaseConfig'; // Assuming you have firebaseApp exported from firebaseConfig.js

// Initialize Firestore database
const db = getFirestore(firebaseApp);

// Add a document to a Firestore collection
export const addDocument = async (collectionName, data) => {
  try {
    const docRef = await addDoc(collection(db, collectionName), data);
    return docRef.id; // Return the ID of the newly added document
  } catch (error) {
    console.error('Error adding document:', error);
    throw error;
  }
};

// Get all documents from a Firestore collection
export const getAllDocuments = async (collectionName) => {
  try {
    const querySnapshot = await getDocs(collection(db, collectionName));
    return querySnapshot.docs.map((doc) => ({ id: doc.id, ...doc.data() }));
  } catch (error) {
    console.error('Error getting documents:', error);
    throw error;
  }
};

// Update a document in a Firestore collection
export const updateDocument = async (collectionName, docId, data) => {
  try {
    const docRef = doc(db, collectionName, docId);
    await updateDoc(docRef, data);
    console.log('Document updated successfully');
  } catch (error) {
    console.error('Error updating document:', error);
    throw error;
  }
};

// Delete a document from a Firestore collection
export const deleteDocument = async (collectionName, docId) => {
  try {
    const docRef = doc(db, collectionName, docId);
    await deleteDoc(docRef);
    console.log('Document deleted successfully');
  } catch (error) {
    console.error('Error deleting document:', error);
    throw error;
  }
};

// Other Firestore operations can be added based on your application's requirements
