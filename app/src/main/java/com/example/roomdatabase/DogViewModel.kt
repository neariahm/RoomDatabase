package com.example.roomdatabase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase.DogAPI.DogAPI.retrofitService
import kotlinx.coroutines.launch

/* The ViewModel class is used to store and manage User Interface (UI) related data.
        For ex. Data survives configuration changes like screen rotations.
*/
class DogViewModel : ViewModel() {
    /* - Create an instance of DogPhoto to get access to the variables we created in the data class.
       - Create a private val to use within the DogViewModel and a getter val that will be used to
         expose this data to the MainActivity class.
     */
    private val _currentlyDisplayedDogPhoto = MutableLiveData<DogPhoto>()
    val currentlyDisplayedDogPhoto: LiveData<DogPhoto> = _currentlyDisplayedDogPhoto

// Create init block, which will initialize the application with a photo when the view is created.
    init {
        getNewPhoto()
    }
  /* - Create a function getNewPhoto() that will call the getDogPhotos() function instantiated
       in the DogAPI class.
     - Add a coroutine b/c a lot is happening and we don't want to add more on UI thread*/
     fun getNewPhoto(){
        viewModelScope.launch {
            _currentlyDisplayedDogPhoto.value = DogAPI.DogAPI.retrofitService.getDogPhotos()
        }
    }
}