

// Vue.use(Vuex)

// const editStore ={
//   namespaced: true,
//     state: {
//         userInfo: {},
//         Eshow: false,

//     },
//     mutations:{
//         EditSuccess(state, payload){
//             state.userInfo= {
//               name: payload.name,
//               username: payload.username,
//               password: payload.password,
//               phone: payload.phone,
//               address: payload.address,
//               u_num: payload.u_num
//             }
//             state.Eshow= false
//             router.push({name: 'MyPage'})
//         }
//     },

//     actions: {
//         EditOK({state, commit}){///UserEdit마무리 
//             let userInfo= state.userInfo
            
//             console.log(userInfo)
//             axios
//             .post('http://localhost:9200/api/user/edit', userInfo)
//             .then(Eres =>{
//               console.log("수정완료")
//               console.log(Eres.data)
//               commit('EditSuccess', Eres.data)
              
//             })
//             .catch(() => {
//               console.log("실패")
//             })
      
//           },
//     }
// }