class LayoutManager(private val recycler: Recycler) {

    fun getViewForPosition(pos: Int): View {
        return recycler.getViewForPosition(pos)
    }


}

class Recycler(private val adapter: Adapter) {

    private val recyclerPool = RecyclerPool()

    private val cache = RecyclerCache()

    fun getViewForPosition(pos: Int): View {
        val viewOrNull = cache.getViewForPosition(pos)

        // if view found from cache return cached view
        if (viewOrNull != null) {
            return viewOrNull
        }

        // if we recycle from pool, rebind with new data, and return view
        val viewType = adapter.getViewType(pos)
        val holderOrNull = recyclerPool.getViewHolderByType(viewType)
        if (holderOrNull != null) {
            val holder = holderOrNull
            // todo send pos here to bind data of position which is
            // becoming visible
            adapter.bindViewHolderWithData(holder)
            return holder.view
        }

        // else create new holder, bind with data, and return view
        val holder = adapter.createViewHolder(viewType)
        // todo send pos here to bind data of position which is
        // becoming visible
        adapter.bindViewHolderWithData(holder)
        return holder.view
    }
}


class RecyclerPool {
    private val viewholders = mutableMapOf<ViewType, ViewHolder>()
    fun getViewHolderByType(viewType: ViewType): ViewHolder? {
        return viewholders.get(viewType)
    }
}

abstract class ViewHolder(val view: View)

class PokemonVH(view: View) : ViewHolder(view) {
    fun bind() {}
}

class ShaktimanVH(view: View) : ViewHolder(view) {
    fun bind() {}
}

abstract class Adapter {
    abstract fun getViewType(pos: Int): ViewType
    abstract fun createViewHolder(viewType: ViewType): ViewHolder
    abstract fun bindViewHolderWithData(holder: ViewHolder)
}

class Ch8nAdapter : Adapter() {

    override fun getViewType(pos: Int): ViewType {
        return when (pos) {
            0 -> ViewType.Pokemon
            else -> ViewType.Shaktiman
        }
    }

    override fun createViewHolder(viewType: ViewType): ViewHolder {
        return when (viewType) {
            ViewType.Pokemon -> {
                val view = View()
                PokemonVH(view)
            }
            ViewType.Shaktiman -> {
                val view = View()
                ShaktimanVH(view)
            }
        }
    }

    override fun bindViewHolderWithData(holder: ViewHolder) {
        when (holder) {
            is PokemonVH -> holder.bind()
            is ShaktimanVH -> holder.bind()
        }
    }
}

sealed class ViewType {
    object Pokemon : ViewType()
    object Shaktiman : ViewType()
}

class RecyclerCache {
    private val views = mutableListOf<View?>()
    fun getViewForPosition(pos: Int): View? = views[pos]
}

class View