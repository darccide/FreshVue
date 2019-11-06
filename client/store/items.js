import ItemService from '@/services/ItemService.js'

export const state = () => ({
  items: [],
  item: {},
  cart: []
})

export const mutations = {
  SET_ITEMS(state, items) {
    state.items = items
  },
  SET_ITEM(state, item) {
    state.item = item
  },
  ADD_TO_CART(state, item) {
    let found = state.cart.find((product) => product.itemId === item.itemId)

    if (found) {
      found.quantity++
    } else {
      state.cart.push(item)
    }
  }
}

export const actions = {
  fetchItems({ commit }) {
    return ItemService.getItems().then((response) => {
      commit('SET_ITEMS', response.data)
    })
  },
  fetchItem({ commit }, id) {
    return ItemService.getItem(id).then((response) => {
      commit('SET_ITEM', response.data)
    })
  }
}

export const getters = {
  totalPrice: (state) => {
    let total = 0
    state.cart.filter((item) => {
      total += item.price * item.quantity
    })

    return total
  }
}
