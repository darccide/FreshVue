import axios from 'axios'

const itemInstance = axios.create({
  baseURL: `http://localhost:9000`,
  withCredentials: false,
  headers: {
    Accept: 'application/json',
    'Content-Type': 'application/json'
  }
})

export default {
  getItems() {
    return itemInstance.get('/api/items')
  },
  getItem(id) {
    return itemInstance.get('/api/items/' + id)
  }
}
