<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
<script language="javascript" type="text/javascript">



// -------------------------------- 生成目录索引列表 -------------------------------- 
// ref: http://www.cnblogs.com/wangqiguo/p/4355032.html
// modified by: zzq
function GenerateContentList()
{
    var mainContent = $('#cnblogs_post_body');
    var h2_list = $('#cnblogs_post_body h1');//如果你的章节标题不是h2,只需要将这里的h2换掉即可

    if(mainContent.length < 1)
        return;
 
    if(h2_list.length>0)
    {
        var content = '<a name="_labelTop"></a>';
        content += '<div id="navCategory" style="color:#152e97;">';
        content += '<p style="font-size:18px;"><b>目录</b></p>';
        content += '<ul>';
        for(var i=0; i<h2_list.length; i++)
        {

            var h3_list = $(h2_list[i]).nextAll("h3");
            var li3_content = '';
            for(var j=0; j<h3_list.length; j++)
            {
                var tmp = $(h3_list[j]).prevAll('h2').first();
                if(!tmp.is(h2_list[i]))
                    break;
                var li3_anchor = '<a name="_label' + i + '_' + j + '"></a>';
                $(h3_list[j]).before(li3_anchor);
                li3_content += '<li><a href="#_label' + i + '_' + j + '">' + $(h3_list[j]).text() + '</a></li>';
            }
            
            var li2_content = '';
            if(li3_content.length > 0)
                li2_content = '<li><a href="#_label' + i + '">' + $(h2_list[i]).text() + '</a><ul>' + li3_content + '</ul></li>';
            else
                li2_content = '<li><a href="#_label' + i + '">' + $(h2_list[i]).text() + '</a></li>';
            content += li2_content;
        }
        content += '</ul>';
        content += '</div><p>&nbsp;</p>';
        content += '<hr style="height:1px;border:none;border-top:1px dashed #0066CC;"/>';
        if($('#cnblogs_post_body').length != 0 )
        {
            $($('#cnblogs_post_body')[0]).prepend(content);
        }
    }   
}

GenerateContentList();

// -------------------------------- 生成目录索引列表 -------------------------------- 

// -------------------------------- 添加访问记录 -------------------------------- 

$.ajax({
	type: "POST",
	url: 'https://120.78.167.47:8080/footprint/record',
	data: JSON.stringify({ 
		'url': window.location.href 
	}),
	dataType: 'json',
	contentType: 'application/json;'
});

// -------------------------------- 添加访问记录 -------------------------------- 

</script>