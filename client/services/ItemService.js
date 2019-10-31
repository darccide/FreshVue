import { apiClient } from '@/services/ApiClient.js'

export default {
  getItems() {
    return apiClient.get('/api/items')
  },
  getItem(id) {
    return apiClient.get('/api/items/' + id)
  }
}
