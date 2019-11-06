<template>
    <div class="card-content">
        <p>
            <button class="button is-success is-light is-outlined" @click="addToCart">Add to Cart</button>
        </p>
    </div>
</template>

<script>
    export default {
       props: {
           id: Number,
           name: String,
           price: Number,
           inventory: Number,
           image: String,
           description: String
       },
       data() {
           return {
                   item : {
                       itemId: this.id,
                       itemName: this.name,
                       price: this.price,
                       inventory: this.inventory,
                       image: this.image,
                       itemDescription: this.description,
                       quantity: 1
                    }
                }
         
        },
        methods: {
            addToCart() {
                this.$store.commit('items/ADD_TO_CART', this.item)
            }
        }
    }
</script>

<style lang="scss" scoped>

</style>