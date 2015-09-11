$(document).ready(function(){

  var myPlaylist = new jPlayerPlaylist({
    jPlayer: "#jplayer_N",
    cssSelectorAncestor: "#jp_container_N"
  }, [
	{
	  title:"讲不出再见",
	  artist:"谭咏麟",
	  mp3:"/demo/music/mp3/50651_218036_jiangbuchuzaijian.mp3",
      poster: "/images/m1.jpg"
	},  
    {
      title:"月牙湾",
      artist:"F.I.R",
      mp3:"/demo/music/mp3/yueyawan.mp3",
      poster: "/images/m0.jpg"
    },
    {
      title:"李白",
      artist:"李荣浩",
      mp3:"/demo/music/mp3/1772159168_10831916_libai.mp3",
      poster: "/images/m1.jpg"
    },
    {
      title:"平凡之路",
      artist:"朴树",
      mp3:"/demo/music/mp3/1773346501_15566694_pingfanzhilu.mp3",
      poster: "/images/m0.jpg"
    },
    {
      title:"天涯",
      artist:"任贤齐",
      mp3:"/demo/music/mp3/46934_55578_tianya.mp3",
      poster: "/images/m1.jpg"
    }, 
    {
      title:"命中注定",
      artist:"庾澄庆",
      mp3:"/demo/music/mp3/mingzongzhuding.mp3",
      poster: "/images/m0.jpg"
    },
    {
      title:"讲不出再见",
      artist:"谭咏麟",
      mp3:"/demo/music/mp3/50651_218036_jiangbuchuzaijian.mp3",
      poster: "/images/m1.jpg"
    }
  ], {
    playlistOptions: {
      enableRemoveControls: true,
      autoPlay: true
    },
    swfPath: "js/jPlayer",
    supplied: "webmv, ogv, m4v, oga, mp3",
    smoothPlayBar: true,
    keyEnabled: true,
    audioFullScreen: false
  });
  
  $(document).on($.jPlayer.event.pause, myPlaylist.cssSelector.jPlayer,  function(){
    $('.musicbar').removeClass('animate');
    $('.jp-play-me').removeClass('active');
    $('.jp-play-me').parent('li').removeClass('active');
  });

  $(document).on($.jPlayer.event.play, myPlaylist.cssSelector.jPlayer,  function(){
    $('.musicbar').addClass('animate');
  });

  $(document).on('click', '.jp-play-me', function(e){
    e && e.preventDefault();
    var $this = $(e.target);
    if (!$this.is('a')) $this = $this.closest('a');

    $('.jp-play-me').not($this).removeClass('active');
    $('.jp-play-me').parent('li').not($this.parent('li')).removeClass('active');

    $this.toggleClass('active');
    $this.parent('li').toggleClass('active');
    if( !$this.hasClass('active') ){
      myPlaylist.pause();
    }else{
      var i = Math.floor(Math.random() * (1 + 7 - 1));
      myPlaylist.play(i);
    }
    
  });



  // video

  $("#jplayer_1").jPlayer({
    ready: function () {
      $(this).jPlayer("setMedia", {
        title: "Big Buck Bunny",
        m4v: "http://flatfull.com/themes/assets/video/big_buck_bunny_trailer.m4v",
        ogv: "http://flatfull.com/themes/assets/video/big_buck_bunny_trailer.ogv",
        webmv: "http://flatfull.com/themes/assets/video/big_buck_bunny_trailer.webm",
        poster: "images/m41.jpg"
      });
    },
    swfPath: "js",
    supplied: "webmv, ogv, m4v",
    size: {
      width: "100%",
      height: "auto",
      cssClass: "jp-video-360p"
    },
    globalVolume: true,
    smoothPlayBar: true,
    keyEnabled: true
  });

});