package com.raywenderlich.organize.presentation

import com.raywenderlich.organize.Platform
import kotlin.math.max
import kotlin.math.min

class AboutViewModel : BaseViewModel() {
  private val platform = Platform()

  val items: List<RowItem> = makeRowItems(platform)

  private fun makeRowItems(platform: Platform): List<RowItem> {
    val rowItems = mutableListOf(
      RowItem("Operating System", "${platform.osName} ${platform.osVersion}"),
      RowItem("Device", platform.deviceModel),
      RowItem("CPU", platform.cpuType),
    )
    platform.screen?.let {
      rowItems.add(
        RowItem(
          "Display",
          "${
            max(it.width, it.height)
          }×${
            min(it.width, it.height)
          } @${it.density}x"
        ),
      )
    }
    return rowItems
  }

  data class RowItem(
    val title: String,
    val subtitle: String,
  )

}


