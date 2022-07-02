json.extract! book, :id, :name, :description, :image, :price, :user_id, :created_at, :updated_at
json.url book_url(book, format: :json)
