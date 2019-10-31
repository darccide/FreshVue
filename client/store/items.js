import ItemService from '@/services/ItemService.js'
import CartService from '@/services/CartService.js'

export const state = () => ({
  items: [],
  item: {},
  cart: [],
  cartDisplayStatus: 'idle'
})

export const mutations = {
  SET_ITEMS(state, items) {
    state.items = items
  },
  SET_ITEM(state, item) {
    state.item = item
  },
  UPDATE_CART_DISPLAY: (state, payload) => {
    state.cartDisplayStatus = payload
  },
  EMPTY_CART: (state) => {
    ;(state.cart = []), (state.cartDisplayStatus = 'idle')
  },
  ADD_TO_CART: (state, payload) => {
    let found = state.cart.find((el) => el.id === payload.id)
    found ? (found.quantity += payload.quantity) : state.cart.push(payload)
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
  cartCount: (state) => {
    if (!state.cart.length) return 0
    return state.cart.reduce((ac, next) => ac + next.quantity, 0)
  },
  cartTotal: (state) => {
    if (!state.cart.length) return 0
    return state.cart.reduce((ac, next) => ac + next.quantity * next.price, 0)
  }
}
