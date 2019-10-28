<template>
  <div class="columns is-centered is-multiline">
    <h1>Items</h1>

    <ItemCard
      v-for="(item, index) in items"
      :key="index"
      :item="item"
      :data-index="index"
    />
  </div>
</template>
<script>
import ItemCard from '@/components/ItemCard.vue'
import { mapState } from 'vuex'

export default {
  head() {
    return {
      title: 'Item Listing',
    }
  },
  async fetch({ store, error }) {
    try {
      await store.dispatch('items/fetchItems')
    } catch(e) {
      error({ 
        statusCode: 503, 
        message: 'Unable to fetch items at this time. Please try again.'
      })
    }
  },
  components: {
    ItemCard
  },
  computed: mapState({
    items: state => state.items.items
  })
}
</script>
<style lang="scss" scoped>
  
</style>