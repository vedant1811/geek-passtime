require './main'

Rspec.describe 'site search' do
  describe 'with no nesting' do
    input = "P Ford Car Review\nP Review Car\nP Review Ford\nP Toyota Car\nP Honda Car\nP Car\nQ Ford\nQ Car\nQ Review\nQ Ford Review\nQ Ford Car\nQ cooking French\n"
    main input
  end
  describe 'with 1 level nesting' do
    input = "P Ford Car\nPP Review Car\nPP Review Ford\nP Toyota Car\nPP Car\nQ Ford\nQ Car\nQ Review"
  end
end
