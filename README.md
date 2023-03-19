# NotesApp
A note app for Android

This app allows users to create, read, update, and delete notes. It uses Room data base to persist data after the user closes the app so notes are saved. It also uses DataStore to save the text entered into a card in the case the user clicks back then wants to go back into the note the started creating before saving. When the user deletes a note a snackbar will appear at the button of the screen that gives the user a chance to undo the deletion. 

This note app uses Compose for the UI, Android Navigation to navigate between views, Room for persistent storage, and DataStore for preference.


### NoteApp Screen Recording
https://user-images.githubusercontent.com/50162270/226197851-fc946ee3-9c53-43e1-ba37-3fd90ea3baf1.mp4
