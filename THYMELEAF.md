# Thymeleaf Quick Study Guide
Quick study guide for thymeleaf that you'd probably want to look over and hopefully I explained it thoroughly.

## You probably want to know this.
- Template - An HTML page that are rendered server side. Which means you can manipulate a page with the data you have or have received.
- '`$`' Symbol - In thymeleaf, you use this to use a variable.
- Every thymeleaf property will start with "th:" appended to the beginning of the tag.  i.e
**![](https://lh3.googleusercontent.com/EQEb4uAJ6kVTGD8Rz2xurejr8JlQ5_GnvDObInHc8_0QjANFgh-nMVsH9O1ttFRThejKDqQcCE4nd7kPru3jYbEiWo79L8uvEmtzvsSiaUjPb0KA0AmUAUPBLnWmN-AILt3TVsvo)**

> Anything that is appended with thymeleaf can be dynamically rendered. Which means that you can change the value according to what data is given or what conditions are met.

## Rendering Forms In Thymeleaf.
Every form in HTML needs an *action* property and a *method* property for it to correctly send requests.

## Thymeleaf: `th:action`
Thymeleaf is appended to the action property to be able to send the request to the actual url instead of the relative URL.

> (I’ll be honest I have no clue why you’d need this though it’s highly recommended so nothing goes wrong.)
**![](https://lh3.googleusercontent.com/KIcYNsJlyHmcT80WFzkeyQKmLeBkDkLKt2xe7j2mOxIhFdnx-eCpSRtqQamD6iEx8WRZhPZrQC6jULj-Aq7_QbLuNsVy6NGDNJGXyg2bJge84A9HOvEaB8fOjcZnKTfbIHDO92wX)**
It functions the same as the vanilla action in HTML.

## Thymeleaf: `th:object`
This is a special thymeleaf property that allows you to model a class into your form so you don’t have to spend time decoding everything.

  

This tag takes in a Java Class which is sent through a GET request from your form.

  
  

> This might be hard to understand with text but I’ll include pictures.
**![](https://lh5.googleusercontent.com/YPbSPYQpj8wPjQlCf8spoW-l8SlXk1NRbp_AAdVfCWWJEPnTxgU3wjY2438mfINkTnqg52dnG9IVkkYHOgSgl0waoKxGcOz0dnHBsjESY3MJJ1lxLG2NB5EDgjZNWl-W6BRo205I)**

### What’s Happening here?
First, you define the function type with the decorator, which is a *GET*. This is ***not*** the function that takes the form values, this is ***what the user sees when they access the page***.

The function takes in a model which is used in our code to add an attribute that’s called `user`, and we are giving the user attribute a class which has all our information on how we want to build our user.

**![](https://lh6.googleusercontent.com/MngTqxQt63F_slAc-pd7T3RjHgzqR5AOOgRDP6BztWtH7B6qYGOpqEnAS2LoahI2psZOlNsuKe5SviPBn0HKfHA1NwqnqjpaYRukfZlaJ0tZ89zNLTYM-m5wI4uCad7Q2GyME1Gx)**
Now, you can access your form values in the form now by doing this.
**![](https://lh6.googleusercontent.com/ExBhs8Kh7x4OCnjuJ1hbcsrl36vt9aEoJqNkMyGExbErcBVvC_zbAa6COJbJpLio8zOpo_ZC2gEMUtbBkyNnY0W3-8X9Am-qHhW7qnTb63u4T2RtapuUVC7OQWIYilDKxT-ZO2W7)**
### Let's break it down
First, we define what type of object we will be building, which is a `User`.
Then, we define our fields like normal but we add another thymeleaf property called `th:field`.

This property lets us map what type of input it is with our class.

> For our first field, we have `th:field=”*{username}”` and if we look into our User class.**![](https://lh5.googleusercontent.com/4m5ldoYt2jLgA9XY1THG903Fl3UvZd46UQRVAGayZ5Ur1N1PrWWgXeYPiczEZNlsWQ0t2F6V1JoRr33Zh9ACnIXyplV89vaDwrqHKuzA13i-7SikmlRrzHOwE6qB75bFHMlf-Jwi)**
> We can see that we have a property that is called ‘username’.
Essentially, we are accessing that field and are modifying it to build the User.
And the same thing goes for our password.

Now, to send our request from our client to the server, and actually read the response, we need to have another Mapper which usually is a POST Mapper for most forms as shown here.

> **![](https://lh6.googleusercontent.com/D-7AOSQJyrJScrp-3AoxIbgk5kYA9Tc85FdoCUh04uxJDnhdqXLUneuUQNHsIGQhqrQ2ytoPaXlH_dUC7SyQ2Sq1jHU50H4NqYtPblzgIYVE3QoyvLjHg1TmKyWFkGaJXf5NzpPw)**
> This is a lot more than before but it’s not that hard to understand.

### Let’s start at the parameters that it has.
- `userRegistered` - This param has 2 *Decorators* and a type of `User`. The first decorator, “**@ModelAtrribute**” is specifying what type of form was sent, which you also had defined in our *GET* Map. The second decorator “**@Valid**” is just telling our IDE that its always valid. And the class is what class we defined it as (User).
- `Result` - This parameter is what you can ***control*** as the user output. Think of it as server side validation since you can *reject* their values as such.

After all our parameters out of the way, lets look at the *conditionals*.

The first 4 IF statements check something about the user such as if the user exists, if the emails were both `valid` / `matched`, `same passwords`, `weak password` etc.

The conditionals all have 1 function in them that uses our `Result` parameter from above. The `#rejectValue` method takes in 3 arguments `(classProperty, null, YourError)`. The class property is what you had your `th:field` as. You can specifically choose which part of the form has an **error** and can *reject* it.

  

The last IF statement checks if the results have errors, then returns them to the same page with the *results(errors)*.

> Though, to be able to read these errors, you have to be able to render text to show the user what they did wrong, which you can use the “#fields.errors(“YOURFIELD”)” to access them.

>![](https://lh6.googleusercontent.com/42L3xeHvMP4iZENVK7Z4mPxVyjJzUpYhtDNQe5JDhdWDu-noeEoBpVw56_cKeY1A3or3jZjrB2qycTYSkgxwdR8wUC6mckKJInNr9Jubocc6MKd6jxRm2dgJULZrXCGk1tSIJp7d)
What’s happening here is that we are using another thymeleaf tag, “th:each”, which is a for loop in thymeleaf.

In the tag, you are taking each error in `fields.error` and assigning it to a *local variable* called `error` which can be read in the same tag which is useful for our case.

Next we use the thymeleaf tag `th:text` to display our variable named error.

> Though we still include the string “Validation Error” as a child in our tag to make sure we didn’t do anything wrong in thymeleaf.

And that should be how you handle forms.

## Thymeleaf Rendering Tables
Rendering data in thymeleaf in a table is similar to forms. Though this time you do not need to have 2 Maps, only the GET Request since you are not sending any data back.

### Controller
**![](https://lh3.googleusercontent.com/ZwNESjIZSub5TODEYSWbR-6w20gx5F-jmxpPkv9k629v3bjV049n_XFte6Op38pyVYo5X-H44-YVidNKcJ0tGXfUtMybg1QbDjRDH8r-ve6pWmnD_RVR2VzPW0PtaNXUR4gmRKL3)**
First we define our GET Mappings so we can access it in our browsers.

Then we define a function that takes in 2 parameters, a `request parameter`, and a model.

> A request parameter is what you see in your url such as this, ![](https://lh6.googleusercontent.com/CwgWIUGu-afyF4UFHitlQZqXFVYLVOWrk_5NiJU6Hh18NLXNa7PxdgJ1tH1voKCIjlaSxaEqapgxnLkhxHnpm3USV5kbPS9xqzKheWnWjksOAr7Wpm_9BAY83yZyzTe6JQ4TvMrZ)

This **function parameter** has a ***single decorator*** which describes it as a `RequestParameter` that has has properties such as `name` (the name of the req param), `defaultValue` (if the value wasn’t specified in the url), `required` (which defines if this parameter is required or not).

The **second** parameter is a `Model` parameter like the one in our form which we can attach attributes to.

<hr />

Now, we can attach any type of data to it but this time we will attach a List of Stocks to the attribute `stockPEs`.

Then we return our stocks page.
<hr />

> Now, Thymeleaf supports lists as an array that we can go through which is going to help us tremendously.
 
Let’s move onto the HTML template.

Let’s start with this html.
**![](https://lh6.googleusercontent.com/P-DjyjtyO9aPq6drghmNZgBY075BKYiyt29DT6D4WtyVpRx4W__xTOyaTI8RqrgcOdieGOewn-hHvs-r305ZXOiq1ft9NRTYlAGkvKzs_oPk7tc17eKtDT0Dcqwi9OKxHU3L-tEh)** I have a table that has a header with 2 columns and 0 rows (besides the head of the table).

Before we start, we should look at how our data is structured.
**![](https://lh5.googleusercontent.com/VBXiEO2Rt64_tT420lWR1ypMUJxXg1lloIX4pR9btZ1kkRCZcp76d-vcqgu_cwMJ3hDYHfPvDNynbwYLm4xV1AMcelgb6ZJ3fYdJlc9KRp1fPxTE17ASgRRBLsVLPWeWwySlqn9T)**
> ( Again sorry for not having a better example, I completely forgot I have to head somewhere in the morning.)

  

You can see that we have 2 properties in the class that are `Strings`, which means we can display it in our table.

  

Though keep in mind we sent an ***ARRAY*** of Stocks, not a *single* one which means we have to **iterate** over it. Thymeleaf has a property called `th:each` which I talked about in the form rendering errors.

We can start off by thinking how we can implement this.

Our idea is to render each Stock in their respective rows and has a company and Stonks column in each row.

  

To do this we can start by writing **1** pair of rows. 
> Why do we do this? We are going to use this row as a model on how all rows will look like, since we have a whole array full of the same type.

**![](https://lh4.googleusercontent.com/aM9rbkJ531SHgnotppiXtZTxISLMM-BmUaBHpDKu2nM3Be9C-ET0ixNOwGSShtiACTyBF-DmQEcNJUWW06JwZXZViLwVMPT0u6aB18w-CsnwjXBe_Nyh-Jk-Lei8894F9pmJepb5)** We wrote a normal row tag with a thymeleaf property `th:each` which declares a variable called stocks for each element in stockPE.

<hr />

Now we can access the variable in our children.

> If you’re unsure what children means, I’m referring to the \<td> in the \<tr> cause they are inside the \<tr> tags, hope that helps u understand it

**![](https://lh6.googleusercontent.com/J9CtOQRKQnY3rkwD8TQ2EluBkIB-A-IInznusGI9rsWFOdnDu7C6-VH20tZ4FWaIIiK7W7_qKBJTMVR8YwITSfRKGOhkU1SHYkLhccdeaQ9IvPOMpKj8S-7BiorDju8BoVEyJWz2)** 
As we did in our form example, you can use the Thymeleaf property `th:text` to display variables or any text you want and in our case, we can use it to access properties from each stock.

  

Now, it should render every single row exactly like that but with varying values.
