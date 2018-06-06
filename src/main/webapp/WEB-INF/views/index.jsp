<html>
<head>
    <link rel="stylesheet" type="text/css" href="/static/css/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/static/css/themes/icon.css">
    <script type="text/javascript" src="/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="/static/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/static/js/index.js"></script>
</head>
<body>
<table id="dg" title="My Users" class="easyui-datagrid" style="width:550px;height:250px"
       url="/user"
       method="get"
       toolbar="#toolbar"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="id" width="50">Id</th>
        <th field="name" width="50">Name</th>
        <th field="age" width="50">Age</th>
        <th field="email" width="50">Email</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">New User</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Edit User</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteUser()">Remove User</a>
</div>

<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
     closed="true" buttons="#dlg-buttons">
    <div class="ftitle">User Information</div>
    <form id="fm" method="post">
        <input name="id" id="id" type="hidden">
        <input name="_method" id="method" type="hidden" value="post" />
        <div class="fitem">
            <label>Name:</label>
            <input name="name" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>Age:</label>
            <input name="age" type="number">
        </div>
        <div class="fitem">
            <label>Email:</label>
            <input name="email" class="easyui-validatebox" validType="email">
        </div>
    </form>
</div>
<div id="dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">Save</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
</div>

</body>
</html>
