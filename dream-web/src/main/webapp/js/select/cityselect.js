(function($){
	$.fn.citySelect=function(settings){
		if(this.length<1){return;};
 
		settings=$.extend({
			url:"/common/geographyData.do",
			prov:null,
			city:null,
			dist:null,
			nodata:null,
			required:true
		},settings);

		var box_obj=this;
		var prov_obj=box_obj.find(".prov");
		var city_obj=box_obj.find(".city");
		var dist_obj=box_obj.find(".dist");
		var prov_val=settings.prov;
		var city_val=settings.city;
		var dist_val=settings.dist;
		var select_prehtml=(settings.required) ? "" : "<option value=''>请选择</option>";
		var city_json;

		// 璧嬪€煎競绾у嚱鏁�
		var cityStart=function(){
			var prov_id=prov_obj.get(0).selectedIndex;
			if(!settings.required){
				prov_id--;
			};
			city_obj.empty().attr("disabled",true);
			dist_obj.empty().attr("disabled",true);

			if(prov_id<0||typeof(city_json.citylist[prov_id].c)=="undefined"){
				if(settings.nodata=="none"){
					city_obj.css("display","none");
					dist_obj.css("display","none");
				}else if(settings.nodata=="hidden"){
					city_obj.css("visibility","hidden");
					dist_obj.css("visibility","hidden");
				};
				return;
			};
			
			// 閬嶅巻璧嬪€煎競绾т笅鎷夊垪琛�
			temp_html=select_prehtml;
			$.each(city_json.citylist[prov_id].c,function(i,city){
				var index = city.n.indexOf("-");
				var value = city.n.substr(0,index);
				var code = city.n.substr(index+1);
				temp_html+="<option value='"+code+"'>"+value+"</option>";
			});
			city_obj.html(temp_html).attr("disabled",false).css({"display":"","visibility":""});
			distStart();
		};

		// 璧嬪€煎湴鍖猴紙鍘匡級鍑芥暟
		var distStart=function(){
			var prov_id=prov_obj.get(0).selectedIndex;
			var city_id=city_obj.get(0).selectedIndex;
			if(!settings.required){
				prov_id--;
				city_id--;
			};
			dist_obj.empty().attr("disabled",true);

			if(prov_id<0||city_id<0||typeof(city_json.citylist[prov_id].c[city_id].a)=="undefined"){
				if(settings.nodata=="none"){
					dist_obj.css("display","none");
				}else if(settings.nodata=="hidden"){
					dist_obj.css("visibility","hidden");
				};
				return;
			};
			
			// 閬嶅巻璧嬪€煎競绾т笅鎷夊垪琛�
			temp_html=select_prehtml;
			$.each(city_json.citylist[prov_id].c[city_id].a,function(i,dist){
				var index = dist.s.indexOf("-");
				var value = dist.s.substr(0,index);
				var code = dist.s.substr(index+1);
				temp_html+="<option value='"+ code  +"'>"+ vlaue +"</option>";
			});
			dist_obj.html(temp_html).attr("disabled",false).css({"display":"","visibility":""});
		};

		var init=function(){
			// 閬嶅巻璧嬪€肩渷浠戒笅鎷夊垪琛�
			temp_html=select_prehtml;
			$.each(city_json.citylist,function(i,prov){
				var index = prov.p.indexOf("-");
				var value = prov.p.substr(0,index);
				var code = prov.p.substr(index+1);
				temp_html+="<option value='"+code+"'>"+value+"</option>";
			});
			prov_obj.html(temp_html);

			// 鑻ユ湁浼犲叆鐪佷唤涓庡競绾х殑鍊硷紝鍒欓€変腑銆傦紙setTimeout涓哄吋瀹笽E6鑰岃缃級
			setTimeout(function(){
				if(settings.prov!=null){
					prov_obj.val(settings.prov);
					cityStart();
					setTimeout(function(){
						if(settings.city!=null){
							city_obj.val(settings.city);
							distStart();
							setTimeout(function(){
								if(settings.dist!=null){
									dist_obj.val(settings.dist);
								};
							},1);
						};
					},1);
				};
			},1);

			// 閫夋嫨鐪佷唤鏃跺彂鐢熶簨浠�
			prov_obj.bind("change",function(){
				cityStart();
			});

			// 閫夋嫨甯傜骇鏃跺彂鐢熶簨浠�
			city_obj.bind("change",function(){
				distStart();
			});
		};

		// 璁剧疆鐪佸競json鏁版嵁
		if(typeof(settings.url)=="string"){
			$.getJSON(settings.url,function(json){
				city_json=json;
				init();
			});
		}else{
			city_json=settings.url;
			init();
		};
	};
})(jQuery);