*** Settings ***
Library   SeleniumLibrary
Test Teardown   Close Browser

*** Test Case ***
ลงทะเบียนผู้สนใจทั่วไป
    เข้ามาระบบจัดซื้อจัดจ้าง
    ทำการลงทะเบียนผู้สนใจทั่วไป
    กรอกข้อมูลนายสมเกียรติ
    E1001 : XXX

*** Keywords ***
กรอกข้อมูลนายสมเกียรติ
    Wait Until Element Is Enabled   id:GENERAL_PIN
    Input Text   id:GENERAL_PIN   3301800293587

ทำการลงทะเบียนผู้สนใจทั่วไป
    Click Element   xpath://*[@id="loginDiv"]/div[2]/div/div/div/form/div[2]/div[1]/div/a
    Click Element   id:Btn2
    Wait Until Element Is Enabled   id:SubmitBtn
    Click Element   id:SubmitBtn

เข้ามาระบบจัดซื้อจัดจ้าง
    Open Browser   http://www.gprocurement.go.th/new_index.html
    ...   browser=chrome
    ...   remote_url=http://localhost:4444/wd/hub
    ...   desired_capabilities=browserName:chrome
    Maximize Browser Window 