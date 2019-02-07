requirejs.config({
    paths: {
    	'Vue': 'https://cdnjs.cloudflare.com/ajax/libs/vue/2.2.1/vue.min',
        'vue': 'https://rawgit.com/edgardleal/require-vue/master/dist/require-vuejs',
        'VueRouter': 'https://cdnjs.cloudflare.com/ajax/libs/vue-router/2.1.1/vue-router.min'
    },
    shim: {
        'Vue': {'exports': 'Vue'}
    }
});

require(['Vue', 'VueRouter'], function(Vue, VueRouter){
    Vue.use(VueRouter);
    var asyncComp = function(componentName) {
        return function(resolve) {
            require([componentName], resolve);
        };
    };

    var router = new VueRouter({
    	mode: 'history',
    	routes: [
	        { path: "/component" , component: asyncComp("vue!/js/components/component.html")},
	        { path: "/async", component: asyncComp("vue!/js/components/async.html")}
	    ]
    });

    new Vue({
        data: {
            started: new Date()
        },
        router: router,
        el: '#app'
    });
});
