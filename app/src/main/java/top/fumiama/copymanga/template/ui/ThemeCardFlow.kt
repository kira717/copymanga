package top.fumiama.copymanga.template.ui

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.line_finish.*
import top.fumiama.copymanga.tools.api.CMApi
import top.fumiama.dmzj.copymanga.R

@ExperimentalStdlibApi
open class ThemeCardFlow(private val api: Int, nav: Int) : StatusCardFlow(0, nav, R.layout.fragment_statuscardflow) {
    private var theme = ""
    override fun getApiUrl() =
        getString(api).format(
            CMApi.myHostApiUrl,
            page * 21,
            sortWay[sortValue],
            theme
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.apply {
            getString("path")?.apply { theme = this }
            getString("name")?.apply {
                activity?.toolbar?.title = this
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lineUpdate = line_finish_time
        lineHot = line_finish_pop
    }

    override fun onResume() {
        super.onResume()
        arguments?.getString("name")?.apply {
            activity?.toolbar?.title = this
        }
    }
}