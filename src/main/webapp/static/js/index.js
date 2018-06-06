function newUser(){
    $('#id').val('');
    $('#method').val('post');
    $('#dlg').dialog('open').dialog('setTitle','New User');
    $('#fm').form('clear');
}
function editUser(){
    var row = $('#dg').datagrid('getSelected');
    if (row){
        $('#method').val('put');
        $('#dlg').dialog('open').dialog('setTitle','Edit User');
        $('#fm').form('load',row);
    }
}
function saveUser(){
    $('#fm').form('submit',{
        url: '/user',
        onSubmit: function(){
            return $(this).form('validate');
        },
        success: function(result){
            if (result == 'error'){
                $.messager.show({
                    title: 'Error',
                    msg: result
                });
            } else {
                $('#dlg').dialog('close');		// close the dialog
                $('#dg').datagrid('reload');	// reload the user data
            }
        }
    });
}

function deleteUser(){
    var row = $('#dg').datagrid('getSelected');
    if (row){
        $.messager.confirm('Confirm','Are you sure you want to destroy this user?',function(r){
            if (r){
                $.ajax({
                    url : '/user/' + row.id,
                    data : {_method:'delete'},
                    type : 'POST',
                    success : function (result) {
                        if (result == 'error'){
                            $.messager.show({	// show error message
                                title: 'Error',
                                msg: result.errorMsg
                            });
                        } else {
                            $('#dg').datagrid('reload');	// reload the user data
                        }
                    }
                });
                // $.post('/user/' + row.id, {_method:'delete'}, function(result){
                //     if (result == 'error'){
                //         $.messager.show({	// show error message
                //             title: 'Error',
                //             msg: result.errorMsg
                //         });
                //     } else {
                //         $('#dg').datagrid('reload');	// reload the user data
                //     }
                // },'json');
            }
        });
    }
}