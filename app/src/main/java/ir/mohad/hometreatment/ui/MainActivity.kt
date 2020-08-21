package ir.mohad.hometreatment.ui


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import ir.mohad.hometreatment.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main)
        val navigation = findViewById<View>(R.id.navigation) as BottomNavigationView

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.navigation_payment_manager -> {
                    txtToolbar.text = getString(R.string.hint_payment_manager)
                    loadFragment(PaymentManagerFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_service_request -> {
                    txtToolbar.text = getString(R.string.hint_services_request)
                    loadFragment(ServiceRequestFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_track_request -> {
                    txtToolbar.text = getString(R.string.hint_track_request)
                    loadFragment(TrackRequestFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigation_store -> {
                    txtToolbar.text = getString(R.string.hint_store)
                    loadFragment(StoreFragment())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }


    private fun loadFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun openNursingServices(view: View) {
        loadFragment(RequestNursingServicesOneFragment())
    }

    fun openPrepayment(view: View) {
        loadFragment(PrepaymentFactorFragment())
    }

    fun openStepOne(view: View) {
        loadFragment(RequestNursingServicesTwoFragment())
    }

    fun openStepTwo(view: View) {
        loadFragment(RequestNursingServicesThreeFragment())
    }

    fun openStepThree(view: View) {
        loadFragment(RequestNursingServicesFourFragment())
    }

}