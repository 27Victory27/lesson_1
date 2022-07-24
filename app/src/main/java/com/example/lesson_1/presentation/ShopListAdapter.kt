package com.example.lesson_1.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson_1.R
import com.example.lesson_1.domain.ShopItem

class ShopListAdapter : RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {

    var shopList = listOf<ShopItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    //как создавать вью, с которы будем работать (Этот метод вызовется условно 20 раз - в зависимости от вместительности элемента xml на экране)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShopItemViewHolder
    { //из xml сделать вьюху распарсенную с помощью LayoutInflater метода inflate, и прикрепить к родителю (
        val layout = when (viewType) {
            VIEW_TYPE_DISABLED -> R.layout.item_shop_disabled
            VIEW_TYPE_ENABLED -> R.layout.item_shop_enabled
            else -> throw RuntimeException ("Unknown viwType: $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ShopItemViewHolder(view) //заполеение переменных
    }

    //сюда прилетает созданная вью и позиция этого элемента, по позиции устанавливаем нужный текст (вызывается в моменте скрола для каждого переопредяляющегося элемента)
    override fun onBindViewHolder(
        viewHolder: ShopItemViewHolder,
        position: Int
    ) { //заполнение данными вьюх, которые создали в onCreateViewHolder
        val shopItem = shopList[position]
        viewHolder.view.setOnLongClickListener { true }
        viewHolder.tvName.text = "${shopItem.name}"
        viewHolder.tvCount.text = shopItem.count.toString()
    }

    override fun onViewRecycled(viewHolder: ShopItemViewHolder) {
        super.onViewRecycled(viewHolder)
        viewHolder.tvName.text =""
        viewHolder.tvCount.text =""
        viewHolder.tvName.setTextColor(ContextCompat.getColor(viewHolder.view.context, android.R.color.white))
    }


    override fun getItemCount(): Int {
        return shopList.size
    }

    override fun getItemViewType(position: Int): Int {
        val item = shopList[position]
        return if (item.enabled) {VIEW_TYPE_ENABLED} else {VIEW_TYPE_DISABLED}
    }

    //Класс, который хранит вью. У него есть родительская вью, из кот мы получаем элементы, для которых можно устанавливать значения.
    //Нужен для того, чтобы findViewById вызываелся только для ОДНОГО конкретного элемента, а не для всех
    class ShopItemViewHolder(val view: View) :
        RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvCount = view.findViewById<TextView>(R.id.tv_count)
    }

    companion object {
        const val VIEW_TYPE_ENABLED = 100
        const val VIEW_TYPE_DISABLED = 101
        const val MAX_POOL_SIZE = 10
    }


}