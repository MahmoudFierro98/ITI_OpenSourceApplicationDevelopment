class BooksController < ApplicationController

  http_basic_authenticate_with name: "Mahmoud", password: "fierro1234", except: [:index, :show]
  
  def index
    @books=Book.all
    p @books 
  end

  def show
    @book= Book.find(params[:id])
  end

  def new
    @book = Book.new
  end

  def create 
    @book=Book.new(book_params)
    @book.user_id=1
    
    if @book.save
      redirect_to @book
    else 
      render :new, status: :unprocessable_entity 
    end
  end

  def edit 
    @book= Book.find(params[:id])
  end

  def update
    @book= Book.find(params[:id])
    if @book.update(book_params)
      redirect_to @book
    else 
      render :edit,status: :unprocessable_entity
    end 
  end

  def destroy
    @book= Book.find(params[:id])
    @book.destroy
    redirect_to root_path ,status: :see_other
  end

  private 
  def book_params
    params.require(:book).permit(:name, :image ,:price, :description )
  end
end
