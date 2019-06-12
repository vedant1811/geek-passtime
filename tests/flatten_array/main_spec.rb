#
# run tests using `rspec main_spec.rb`

require './main'

RSpec.describe "main" do
  it do
    input = [[1,2,[3]],4]
    output = [1,2,3,4]
    expect(flatten_array(input)).to eq(output)
  end
  it do
    input = [[1,2,[]],4]
    output = [1,2,4]
    expect(flatten_array(input)).to eq(output)
  end
  it do
    input = [[1,[[],[],[],[]],2,4]]
    output = [1,2,4]
    expect(flatten_array(input)).to eq(output)
  end
  it do
    input = []
    output = []
    expect(flatten_array(input)).to eq(output)
  end
  it do
    input = nil
    output = []
    expect(flatten_array(input)).to eq(output)
  end
end
