function copyValueFromMSName() {
    if ($("#packageName").val() == '') {
        $("#packageName").val($("#msName").val());
    }
}

function changeValueCheckbox(element) {
    if (element.checked) {
        element.value = 'true';
    } else {
        element.value = 'false';
    }
}

const FILE_MAX_COUNT = 10;
const FILE_MAX_SIZE_IN_BYTES = 10485760;
$(function () {
    $("#addYaml").click(addYaml);

});

var addYaml = function () {
    var count = window["YamlFileCount"];
    if (count === undefined) {
        count = 1;
    }
    if (count >= FILE_MAX_COUNT) {
        alert("You can attach only 10 YAML files");
    } else {
    	var html = "";
        html = html + "<div style='margin-top:10px;' id='client_yaml_elemenet_id_" + (count + 1) + "'>";
        html = html + "<label style='margin-right:30px;' class='form-check-label' id='clientYamlLabel" + (count + 1) + "' for='exampleCheck" + (count + 1) + "'>API definition file for client " + (count + 1) + " (OpenAPI YAML file)</label>";
        html = html + "<input style='display:table-cell' type='file' name='clientYaml' id='clientYaml" + (count + 1) + "' onchange='validateFileSize()' accept='.yaml,.yml'/>";
        html = html + "<p class='closebtn' id='clientYamlP" + (count + 1) + "' onclick='deleteClientYaml(this.id);'>&times;</p>";
        html = html + "</div>";
        $("#fileUplodeDiv").append(html);
        count++;
        window["YamlFileCount"] = count;
    }
};

function validateFileSize() {
    let files = [document.getElementById("apiYaml"), document.getElementById("clientYaml")];
    for (let i = 1; i <= FILE_MAX_COUNT; i++) {
        files.push(document.getElementById("clientYaml" + i));
    }
    files = files.filter(element => element !== null);
    files.forEach(e => {
        if (e.files[0] !== undefined) {
            if (e.files[0].size > FILE_MAX_SIZE_IN_BYTES) {
                alert("File is too big!");
                e.value = "";
            }
        }
    })
}


function deleteClientYaml(id) {
    var count = window["YamlFileCount"];
    var index = id.replace("clientYamlP", "");
    $("#clientYamlLabel" + index).remove();
    $("#clientYaml" + index).remove();
    $("#clientYamlP" + index).remove();
    $("#client_yaml_elemenet_id_" + index).remove();
    count--;
    window["YamlFileCount"] = count;
    let files = [];
    let labels = [];
    let ps = [];
    for (let i = 2; i <= FILE_MAX_COUNT; i++) {
        files.push(document.getElementById("clientYaml" + i));
        labels.push(document.getElementById("clientYamlLabel" + i));
        ps.push(document.getElementById("clientYamlP" + i));
    }
    files = files.filter(element => element !== null);
    ps = ps.filter(element => element !== null);
    labels = labels.filter(element => element !== null);
    for (let i = 0; i < FILE_MAX_COUNT; i++) {
        $("#clientYamlLabel" + (i + 2)).remove();
        $("#clientYaml" + (i + 2)).remove();
        $("#clientYamlP" + (i + 2)).remove();
        $("#client_yaml_elemenet_id_" + (i + 2)).remove();
    }
    for (let i = 0; i < files.length; i++) {
        files[i].id = "clientYaml" + (i + 2);
        ps[i].id = "clientYamlP" + (i + 2);
        labels[i].id = "clientYamlLabel" + (i + 2);
        labels[i].innerHTML = "API definition file for client "+(i + 2)+" (OpenAPI YAML file)";
        $("#fileUplodeDiv").append("<div style='margin-top:10px;' id='client_yaml_elemenet_id_" + (i + 2) + "'></div>");
        $("#fileUplodeDiv #client_yaml_elemenet_id_" + (i + 2) + "").append(labels[i]);
        $("#fileUplodeDiv #client_yaml_elemenet_id_" + (i + 2) + "").append(files[i]);
        $("#fileUplodeDiv #client_yaml_elemenet_id_" + (i + 2) + "").append(ps[i]);
    }
}
