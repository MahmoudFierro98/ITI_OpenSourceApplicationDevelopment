Rails.application.routes.draw do
  get 'static_pages/home'
  # Define your application routes per the DSL in https://guides.rubyonrails.org/routing.html
  get "/books", to: "books#index"
  # get "/books/:id", to: "books#show"
  # Defines the root path route ("/")
  root "books#index"

  resources :books 
  
  
end
