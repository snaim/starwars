package com.naim.starwars.ui.tripdetail

import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.kodein
import com.github.salomonbrys.kodein.with
import com.naim.starwars.MainActivity
import com.naim.starwars.R
import com.naim.starwars.ui.model.ViewTripDetailModel
import com.naim.starwars.ui.mvpekino.MvpKodeinFragment
import kotlinx.android.synthetic.main.fragment_trip_detail.arrival
import kotlinx.android.synthetic.main.fragment_trip_detail.arrival_time
import kotlinx.android.synthetic.main.fragment_trip_detail.departure
import kotlinx.android.synthetic.main.fragment_trip_detail.departure_time
import kotlinx.android.synthetic.main.fragment_trip_detail.detail_pilot_name
import kotlinx.android.synthetic.main.fragment_trip_detail.pilot_avatar
import kotlinx.android.synthetic.main.fragment_trip_detail.trip_distance
import kotlinx.android.synthetic.main.fragment_trip_detail.trip_duration

/**
 * TripDetailFragment -
 *
 * @author naim
 * @version $Id$
 */
class TripDetailFragment
    : MvpKodeinFragment<TripDetailContract.Presenter>(), TripDetailContract.View {

    override val defaultLayout: Int = R.layout.fragment_trip_detail

    override val presenter: TripDetailContract.Presenter by lazy {
        kodein().value
                .with(arguments?.getInt(KEY_ID))
                .instance<TripDetailContract.Presenter>()
    }

    companion object {
        private const val KEY_ID = "tripid"

        fun newInstance(id: Int): TripDetailFragment {
            val bundle = Bundle()
            bundle.putInt(KEY_ID, id)
            return TripDetailFragment().apply {
                arguments = bundle
            }
        }
    }

    override fun setData(trip: ViewTripDetailModel) {
        detail_pilot_name.text = trip.pilotName
        departure.text = trip.pickupName
        arrival.text = trip.dropoffName

        departure_time.text = trip.pickupTime // TODO
        arrival_time.text = trip.dropoffTime // TODO

        trip_distance.text = trip.distance.toString() + trip.distanceUnit // TODO

        trip_duration.text = trip.duration // TODO

        Glide.with(requireContext())
                // TODO
                .load(resources.getString(R.string.base_url) + trip.pilotAvatar)
                .into(pilot_avatar)
    }


    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun setLoadingState(isLoading: Boolean) {
        (activity as MainActivity).setLoadingState(isLoading)
    }

    override fun provideOverridingModule() = Kodein.Module {
        bind<TripDetailContract.View>() with instance(this@TripDetailFragment)
    }

}
