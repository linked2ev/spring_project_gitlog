define([
  './components/sample',
  './components/leftMenu'
  ], function(Sample, LeftMenu){
    return [
      {
        path:'/components/sample',
        component: Sample
      },
      {
        path:'/components/leftMenu',
        component: LeftMenu
      }
    ] 
  });