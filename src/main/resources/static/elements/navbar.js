<div class="navbar-header">
	<a href="/" class="navbar-brand"><i class="fa fa-tachometer"
		aria-hidden="true"></i> <b>Shadow-NET</b></a>
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#top-navbar">
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
		</button>
</div>

<div class="collapse navbar-collapse pull-left" id="top-navbar">
<ul class="nav navbar-nav">
	<li class="dashboard"><a href="/"> 
		 <i class="fa fa-laptop"></i>
		 <span> Dashboard </span>
		</a>
	</li>
	
	<li class="dropdown stats">
	<a href="#"  class="dropdown-toggle" data-toggle="dropdown">
	<i class="fa fa-bar-chart"></i> Statistics <b class="caret"></b>
	</a>
	<ul class="dropdown-menu" role="menu">
		<li><a href="/statistics">Top 10 Countries</a></li>
		<li><a href="/statistics#top10ips">Top 10 IPs</a></li>
		<li><a href="/statistics#top10urls">Top 10 Urls</a></li>
		<li><a href="/statistics#top10hashes">Top 10 Hashes</a></li>
    </ul>
	</li>

	<li class="blocklist">
        <a href="/blocklist">
            <i class="fa fa-ban"></i> Blocklist
        </a>
    </li>
</ul>
</div>

<ul class="nav navbar-nav navbar-right">
<li class="dropdown navbar-user"><a href="javascript:;"
	class="dropdown-toggle" data-toggle="dropdown"> <img
		src="assets/img/user-7.jpg" alt="" /> <span class="hidden-xs">
		<text id="user"></text></span> <b
		class="caret"></b>
</a>
	<ul class="dropdown-menu animated fadeInLeft">
		<li class="arrow"></li>
		<li><a href="/">Dashboard</a></li>
		<li><a href="/blocklist">Block List</a></li>
		<li data-toggle="modal" data-target=".bd-example-modal-lg"><a
			href="javascript:;">Clear Database</a></li>
		<li class="divider"></li>
		<li id="form" style="padding-left: 10px"></li>
	</ul></li>
</ul>