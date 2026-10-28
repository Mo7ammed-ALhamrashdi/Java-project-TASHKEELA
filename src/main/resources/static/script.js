const API = "http://localhost:8080/api";



/* =========================
   PAGE PROTECTION
========================= */


const publicPages = [
    "login.html",
    "register.html",
    "verify.html",
    "forgot-password.html"
];



window.onload = function(){

    let page =
        window.location.pathname.split("/").pop();


    let token =
        localStorage.getItem("token");


    if(
        !publicPages.includes(page)
        &&
        !token
    ){

        window.location.href="login.html";

    }


    applyLanguage();

};





/* =========================
        LOGIN
========================= */


async function login(){


    let email =
        document.getElementById("email").value;


    let password =
        document.getElementById("password").value;



    try{


        let response =
            await fetch(

                API + "/auth/login",

                {

                    method:"POST",

                    headers:{

                        "Content-Type":
                            "application/json"

                    },


                    body:JSON.stringify({

                        email:email,

                        password:password

                    })


                }

            );




        let data =
            await response.json();




        localStorage.setItem(

            "email",

            email

        );




        alert(
            data.message
        );



        window.location.href=
            "verify.html";



    }
    catch(error){

        alert(
            "Login Failed"
        );

    }


}








/* =========================
        VERIFY OTP
========================= */


async function verifyOTP(){



    let email =
        localStorage.getItem("email");



    let otp =
        document.getElementById("otp").value;




    try{


        let response =
            await fetch(

                API+"/auth/verify-otp",

                {

                    method:"POST",

                    headers:{

                        "Content-Type":
                            "application/json"

                    },


                    body:JSON.stringify({

                        email:email,

                        otp:otp

                    })

                }

            );




        let token =
            await response.text();




        if(token.includes("Invalid")){

            throw new Error();

        }





        localStorage.setItem(

            "token",

            token

        );



        alert(
            "Login Successfully"
        );



        window.location.href=
            "dashboard.html";



    }

    catch(e){

        alert(
            "Wrong OTP"
        );

    }



}








/* =========================
        REGISTER
========================= */


async function register(){



    let user={


        fullName:
        document.getElementById("fullName").value,


        email:
        document.getElementById("email").value,


        password:
        document.getElementById("password").value,


        role:"USER"


    };




    let response =
        await fetch(

            API+"/auth/register",

            {

                method:"POST",


                headers:{

                    "Content-Type":
                        "application/json"

                },


                body:
                    JSON.stringify(user)


            }

        );





    if(response.ok){


        alert(
            "Account Created"
        );


        window.location.href=
            "login.html";


    }

    else{


        alert(
            "Registration Failed"
        );


    }


}









/* =========================
        LOGOUT
========================= */


function logout(){


    localStorage.removeItem(
        "token"
    );


    localStorage.removeItem(
        "email"
    );


    window.location.href=
        "login.html";


}









/* =========================
        FORGOT PASSWORD
========================= */



async function sendResetOTP(){



    let email =
        document.getElementById("resetEmail").value;




    await fetch(

        API+"/auth/forgot-password",

        {

            method:"POST",

            headers:{

                "Content-Type":
                    "application/json"

            },


            body:JSON.stringify({

                email:email

            })

        }

    );



    alert(
        "OTP Sent"
    );


}








async function resetPassword(){



    let email =
        document.getElementById("resetEmail").value;



    let otp =
        document.getElementById("resetOTP").value;



    let password =
        document.getElementById("newPassword").value;





    let response =
        await fetch(

            API+"/auth/reset-password",

            {

                method:"POST",

                headers:{

                    "Content-Type":
                        "application/json"

                },


                body:JSON.stringify({

                    email:email,

                    otp:otp,

                    password:password

                })


            }

        );





    if(response.ok){


        alert(
            "Password Changed"
        );


        window.location.href=
            "login.html";


    }

}









/* =========================
        LANGUAGE
========================= */


function changeLanguage(){


    let lang =
        localStorage.getItem("lang")
        ||
        "en";



    if(lang==="en"){

        localStorage.setItem(
            "lang",
            "ar"
        );

    }

    else{


        localStorage.setItem(
            "lang",
            "en"
        );


    }



    applyLanguage();

}





function applyLanguage(){


    let lang =
        localStorage.getItem("lang")
        ||
        "en";



    document.documentElement.lang =
        lang;



    if(lang==="ar"){

        document.documentElement.dir="rtl";

    }

    else{

        document.documentElement.dir="ltr";

    }


}






/* =========================
        AI
========================= */


function askAI(){



    let result =
        document.getElementById("aiResult");



    result.innerHTML =
        "🤖 AI Thinking...";



    setTimeout(()=>{


        result.innerHTML =

            `
        <h3>
        AI Recommendation
        </h3>

        <p>
        Use 4-3-3 formation
        </p>

        <p>
        Select strong Omani midfielders
        </p>

        `;


    },1500);



}