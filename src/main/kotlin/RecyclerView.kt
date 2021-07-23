/**
 *  Layout Manager :
 *  - Position the Views
 *  - Scrolling Views
 */
class LayoutManager(private val recycler: Recycler) {
    fun getViewForPosition(pos: Int): View {
        return recycler.getViewOrNull(pos)
    }
}

/**
 *  Recycler View :
 *  - Coordinator of all component
 *  - Interaction with Elements
 */
class Recycler(
    private val adapter: Adapter,
    private val recyclerPool: RecyclerPool,
    private val viewCache: ViewCache
) {

    fun getViewOrNull(pos: Int): View {
        val viewOrNull = viewCache.getOrNull(pos)
        // view found then return view
        if (viewOrNull != null) {
            return viewOrNull
        }
        val viewType = adapter.getViewType(pos)
        val holderOrNull = recyclerPool.getViewHolderByType(viewType)
        // view holder found -> bind and return view
        if (holderOrNull != null) {
            adapter.bindViewHolder(holderOrNull)
            viewCache.put(pos, holderOrNull.itemView)
            return holderOrNull.itemView
        }

        // create and bind view holder and return view
        val holder = adapter.createViewHolder(viewType)
        adapter.bindViewHolder(holder)
        viewCache.put(pos, holder.itemView)
        return holder.itemView
    }
}

/***
 *  Recycler View Cache
 */
class ViewCache {

    private val viewCache = mutableMapOf<Int, View>()

    fun getOrNull(pos: Int): View? = viewCache.get(pos)

    fun put(pos: Int, view: View) {
        viewCache.put(pos, view)
    }
}


/**
 *  Adapter :
 *  - Provide the View
 *  - Create View and ViewHolder
 *  - binding data to ViewHolder
 *  - Notify Recycler Changes -> Not clear in video
 *  - Notify out of sync? -> Not clear in video
 *  - Item interactions
 *  - Multiple View Types
 *  - Recycle Recovery
 */
abstract class Adapter {
    abstract fun getViewType(pos: Int): ViewType
    abstract fun bindViewHolder(holder: ViewHolder)
    abstract fun createViewHolder(viewType: ViewType): ViewHolder
}

/**
 *  Item Animator :
 *  - Animates the views
 */
class ItemAnimator {

}

/**
 *  View Holder :
 *  - item interaction handler
 */
abstract class ViewHolder(private val view: View) {
    val itemView get() = view
}

/**
 *  Recycler Pool :
 *  - Cache of Recycler View-Holder
 */
class RecyclerPool {
    private val cache = mutableMapOf<ViewType, ViewHolder>()
    fun getViewHolderByType(viewType: ViewType): ViewHolder? {
        return cache.get(viewType)
    }
}

/**
 * Represent Android View
 */
class View

/**
 * Represent ViewTypes which user provides
 */
sealed class ViewType {
    object ListItemContent : ViewType()
    object ListItemHeader : ViewType()
}

/**
 * Test View Holders
 */
class ContentHeader(view: View) : ViewHolder(view) {
    fun bind(){}
}
class ContentItem(view: View) : ViewHolder(view) {
    fun bind(){}
}

/**
 * Test Implementation of Adapter Class
 */

class TestAdapter : Adapter() {

    /**
     * Similar to getItemViewType() of Recycler Adapter
     */
    override fun getViewType(pos: Int): ViewType {
        return when (pos) {
            0 -> ViewType.ListItemHeader
            else -> ViewType.ListItemContent
        }
    }

    /**
     * Similar to onBindViewHolder() of Recycler Adapter
     */
    override fun bindViewHolder(holder: ViewHolder) {
        when (holder) {
            is ContentHeader -> holder.bind()
            is ContentItem -> holder.bind()
        }
    }

    /**
     * Similar to onCreateViewHolder() of Recycler Adapter
     */
    override fun createViewHolder(viewType: ViewType): ViewHolder {
        when (viewType) {
            ViewType.ListItemContent -> TODO()
            ViewType.ListItemHeader -> TODO()
        }
    }
}