import { apiClient } from '@/services/ApiClient.js'

export default {
  postCart(lineItems) {
    return apiClient.post('/api/carts', { lineItems })
  }
}
