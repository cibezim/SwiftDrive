import { getStorage, ref, uploadBytesResumable, getDownloadURL } from 'firebase/storage';

const StorageService = {
  // Uploads a file to Firebase Storage
  uploadFile: async (file, path) => {
    const storage = getStorage();
    const storageRef = ref(storage, path + '/' + file.name);
    const uploadTask = uploadBytesResumable(storageRef, file);

    try {
      const snapshot = await uploadTask;
      console.log('File uploaded successfully');
      const downloadURL = await getDownloadURL(snapshot.ref);
      return downloadURL;
    } catch (error) {
      console.error('Error uploading file:', error.message);
      throw error;
    }
  },

  // Delete a file from Firebase Storage
  deleteFile: async (path) => {
    const storage = getStorage();
    const storageRef = ref(storage, path);

    try {
      await storageRef.delete();
      console.log('File deleted successfully');
    } catch (error) {
      console.error('Error deleting file:', error.message);
      throw error;
    }
  }
};

export default StorageService;
