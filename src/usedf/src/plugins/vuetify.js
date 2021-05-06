import Vue from 'vue'
import Vuetify from 'vuetify'


Vue.use(Vuetify)

export default new Vuetify({
  theme: {
    themes: {
      light: {
        primary: '#1182F3',
        secondary: '#ECECEC', 
        error: '#F00000', 
        green: '#31C923',
        grey: '#bebebe'
      },
    },
  },
})