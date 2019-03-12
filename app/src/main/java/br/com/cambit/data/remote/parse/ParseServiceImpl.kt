package br.com.cambit.data.remote.parse

import android.content.Context
import br.com.cambit.BuildConfig
import com.parse.Parse
import com.parse.ParseACL

class ParseServiceImpl(private val context: Context) : ParseService {

    override fun init() {
        Parse.enableLocalDatastore(context)

        Parse.initialize(
            Parse.Configuration.Builder(context)
                .applicationId(BuildConfig.BACKAPP_APP_ID)
                .clientKey(BuildConfig.BACKAPP_CLIENT_KEY)
                .server(BuildConfig.BACKAPP_SERVER_URL)
                .build()
        )

        val defaultACL = ParseACL()
        defaultACL.publicReadAccess = true
    }
}