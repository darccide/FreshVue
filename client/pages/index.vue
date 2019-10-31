<template>
  <div>
    <Landing />
  </div> 
</template>
<script>
// import ItemCard from '@/components/ItemCard.vue'
import Landing from '@/components/Landing.vue'
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
    Landing
  },
  computed: mapState({
    items: state => state.items.items
  })
}
</script>
<style lang="scss" scoped>
  body {
      background-color: hsl(141, 71%, 48%);
  }
</style>