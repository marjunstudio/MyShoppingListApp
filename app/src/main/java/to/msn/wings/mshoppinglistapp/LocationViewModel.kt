package to.msn.wings.mshoppinglistapp

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LocationViewModel: ViewModel() {
    private val _location = mutableStateOf<LocationData?>(null)
    val location: State<LocationData?> = _location

    private val _address = mutableStateOf(listOf<GeocodingResult>())
    val address: State<List<GeocodingResult>> = _address


    fun updateLocation(newLocation: LocationData) {
        _location.value = newLocation
    }

    fun fetchAddress(latlng: String) {
        try {
            viewModelScope.launch {
                val result = RetrofitClient.create().getAddressFromCoordinates(
                    latlng,
                    "AIzaSyBi5Ake6s4-6LaFilOBWNktUu-B5i1Ju24"
                )
                Log.d("いち", result.results.toString())
                _address.value = result.results
            }
        }catch(e:Exception) {
            Log.d("res1", "${e.cause} ${e.message}")
        }
    }
}