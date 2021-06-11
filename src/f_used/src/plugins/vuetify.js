import Vue from 'vue'
import Vuetify from 'vuetify'


Vue.use(Vuetify)
const opts = {}

export default new Vuetify(opts,{
  theme: {
    themes: {
      light: {
        primary: '#1182F3',
        secondary: '#ECECEC', 
        error: '#F00000', 
        green: '#31C923',
        grey: '#bebebe',
        skyblue:'#66CCFF',
        brown:'#996633',
        yellow: '#FFCC00',
        aa: '#66CCCC',
        skygreen: '#90EE90',
        purple: '#9999FF',
        

      },
    },
  },
})